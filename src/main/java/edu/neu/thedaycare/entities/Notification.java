package edu.neu.thedaycare.entities;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import edu.neu.thedaycare.EmailService;
import edu.neu.thedaycare.repository.ImmunizarionRequirementsRepository;
import edu.neu.thedaycare.repository.ImmunizationRecordsRepository;
import edu.neu.thedaycare.repository.StudentRepository;

//@SpringBootApplication
public class Notification {
	
	@Autowired
	@Resource
	StudentRepository stur;

	@Autowired
	@Resource
	ImmunizarionRequirementsRepository immurq;

	@Autowired
	@Resource
	ImmunizationRecordsRepository immurec;

//	@Scheduled(cron = "* * * * *")
	@Scheduled(initialDelay = 1000L, fixedRate = 60000L)
	public void annualRegistration() throws InterruptedException {
		List<Student> ss = stur.findAll();
		
		LocalDate today = LocalDate.now();
    	String from = "The Day Care <notifications@thedaycare.com>";
		EmailService es = new EmailService();
		
		for (Student s: ss) {
			Integer days = Period.between(s.getRegistrationDate(), today).getDays();
			if (days <= 10) {
				Guardian g = s.getPrimaryGuardian();
				
				String to = g.getEmail();
				String subject = "Annual Registration!";
				String body = "Hello "
						+ g.getFullName() + ",\n"
						+ g.getRelationship() + " of " + s.fullName() + ", please note that your annual "
								+ "registration is due as of " + s.getRegistrationDate();
						
				es.sendSimpleMessage(to, from, subject, body);
				Thread.sleep(3000L);
			}
		}
		
	}
	
	
	@Scheduled(fixedRate = 60000L)
	public void immunizationAniversary() throws InterruptedException {
		int preschoolAge = 2 * 12;

		List<Student> ss = stur.findAll();

		List<ImmunizationRequirements> immupre = immurq.findByLevel("preschool");
		List<ImmunizationRequirements> immukin = immurq.findByLevel("kindergarten");
		
		LocalDate today = LocalDate.now();
    	String from = "The Day Care <notifications@thedaycare.com>";
		EmailService es = new EmailService();
    	
    	for (Student s : ss) {
			Guardian g = s.getPrimaryGuardian();

			List<ImmunizationRecords> simm = immurec.findAllByStudentId(s.getId());
			if (simm.size() == 0) {
				String to = g.getEmail();
				String subject = "All Immunization records missing";
				String body = "Hello "
						+ g.getFullName() + ",\n"
						+ g.getRelationship() + " of " + s.fullName() + ", please note that your all of you "
								+ "childs immunization records are missing. Please provide them.";
						
				es.sendSimpleMessage(to, from, subject, body);
				Thread.sleep(3000L);
				continue;
			}
    		if (s.getAge() <= preschoolAge) {
    			for (ImmunizationRequirements imm : immupre) {
    				List<ImmunizationRecords> thisimm = immurec.findAllByImmunizationRequirementsId(imm.getId());
    				if (thisimm.size() == 0) {
						String to = g.getEmail();
						String subject = imm.getName() + " Immunization records missing";
						String body = "Hello "
								+ g.getFullName() + ",\n"
								+ g.getRelationship() + " of " + s.fullName() + ", please note that " + imm.getDoses() 
								+ " are required and " + thisimm.size()
								+ " are provided, please take the remaning doses.";
								
						es.sendSimpleMessage(to, from, subject, body);
						Thread.sleep(3000L);
						continue;
    				} else if(thisimm.size() < imm.getDoses()) {
    					LocalDate lastDoseTakenDate = thisimm
    							.stream()
    							.map(o -> o.getWhenDate())
    							.max(LocalDate::compareTo).get();
    					int diffMon = Period.between(lastDoseTakenDate, LocalDate.now()).getMonths();
    					
    					if (diffMon > imm.getMonthsApart()) {
							String to = g.getEmail();
							String subject = imm.getName() + " Immunization records missing";
							String body = "Hello "
									+ g.getFullName() + ",\n"
									+ g.getRelationship() + " of " + s.fullName()
									+ ", please note that " + imm.getDoses() + " are required."
									+ " Its been " + diffMon + " months since your last dose of "
									+ imm.getName()
									+ " , please take the remaning doses.";
									
							es.sendSimpleMessage(to, from, subject, body);
							Thread.sleep(3000L);
							continue;
    						
    					}
    					
    				}
    			}
    		}
    		
    	}
	}
}
