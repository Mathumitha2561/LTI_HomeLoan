//package com.lti.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.lti.dao.LoanRepository;
//import com.lti.dao.PropertyRepository;
//import com.lti.dao.SalariedRepository;
//import com.lti.dao.SelfEmployeedRepository;
//import com.lti.dao.UserRepository;
//import com.lti.entity.Account;
//import com.lti.entity.LoanApplication;
//import com.lti.entity.Property;
//import com.lti.entity.Salaried;
//import com.lti.entity.SelfEmployeed;
//import com.lti.entity.User;
//import com.lti.exception.AppExcep;
//
//@Service
//public class HomeLoanServiceImpl implements HomeLoanService 
//{
//	@Autowired
//	private UserRepository urs;
//	@Autowired
//	private SalariedRepository salrep;
//	@Autowired
//	private SelfEmployeedRepository selfemprep;
//	@Autowired
//	private PropertyRepository proprep;
//	@Autowired
//	private LoanRepository loanrep;
//	
//	@PersistenceContext
//	EntityManager em;
//	
//	@Transactional
//	@Override
//	public User registerUser(User users) 
//	{
//			urs.save(users);
//			return users;
//	}
//
//	@Transactional
//	@Override
//	public User loginProcess(User user)
//	{
//		int check=0;
//		User u1 = null;
//		try {
//			String emailid =  user.getEmailId();
//			String password = user.getPassword();
//			u1 = (User)em.createQuery("select u from User u where  u.emailId=:emailid").setParameter("emailid", emailid).getSingleResult();
//			if(( u1.getEmailId().equals(emailid)) && (u1.getPassword().equals(password))) {
//				
//				check = 1;
//			}
//			else {
//				check = 0;
//				}
//		}
//		catch(Exception e)
//		{
//			System.out.println(e);
//		}
//		if(check==1)
//		{
//			return u1;
//		}
//		return null;
//	}
//	@Transactional
//	@Override
//	public Salaried addSalariedDetails(Salaried salaried)
//	{
//		
//			salrep.save(salaried);
//			return salaried;
//	
//	}
//
//	@Transactional
//	@Override
//	public SelfEmployeed addSelfEmployeedDetails(SelfEmployeed selfemployeed) 
//	{
//		
//			selfemprep.save(selfemployeed);
//			return selfemployeed;
//		
//	}
//
//	@Transactional
//	@Override
//	public Property addPropertyDetails(Property property)
//	{
//			proprep.save(property);
//			return property;
//	}
//
//	@Transactional
//	@Override
//	public LoanApplication addLoanDetails(LoanApplication application) 
//	{
//		loanrep.save(application);
//		return application;
//	}
//
//	@Override
//	public User getUserInfobyId(int userId) 
//	{
//		Optional<User> userfind = urs.findById(userId);
//		User user = null;
//		if (userfind.isPresent()) {
//			user = userfind.get();
//		}
//		
//		return user;
//	}
//
//	@Override
//	public List<User> getAllUsers() 
//	{
//		List<User> ulist=urs.findAll();
//		return ulist;
//	}
//	@Transactional
//	@Override
//	public List<LoanApplication> findApplicationById(int userId) 
//	{
//		Query q1 = em.createQuery("Select l from LoanApplication l where USER_ID=:idd");
//		q1.setParameter("idd",userId);
//		List<LoanApplication> list=q1.getResultList();
//		return list;
//	}
//	
//	@Transactional
//	@Override
//	public List<Account> getAccountListbyAppId(int appId)
//	{
//		Query q1 = em.createQuery("Select a from Account a where APPLICATIONID=:appid");
//		q1.setParameter("appid",appId);
//		List<Account> list=q1.getResultList();
//		return list;
//	}
//
//}
package com.lti.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.LoanRepository;
import com.lti.dao.PropertyRepository;
import com.lti.dao.SalariedRepository;
import com.lti.dao.SelfEmployeedRepository;
import com.lti.dao.UserRepository;
import com.lti.entity.Account;
import com.lti.entity.LoanApplication;
import com.lti.entity.Property;
import com.lti.entity.Salaried;
import com.lti.entity.SelfEmployeed;
import com.lti.entity.User;
import com.lti.exception.AppExcep;

@Service
public class HomeLoanServiceImpl implements HomeLoanService 
{
	@Autowired
	private UserRepository urs;
	@Autowired
	private SalariedRepository salrep;
	@Autowired
	private SelfEmployeedRepository selfemprep;
	@Autowired
	private PropertyRepository proprep;
	@Autowired
	private LoanRepository loanrep;
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public User registerUser(User users) 
	{
			urs.save(users);
			return users;
	}

	@Transactional
	@Override
	public User loginProcess(User user)
	{
		int check=0;
		User u1 = null;
		try {
			String emailid =  user.getEmailId();
			String password = user.getPassword();
			u1 = (User)em.createQuery("select u from User u where  u.emailId=:emailid").setParameter("emailid", emailid).getSingleResult();
			if(( u1.getEmailId().equals(emailid)) && (u1.getPassword().equals(password))) {
				
				check = 1;
			}
			else {
				check = 0;
				}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		if(check==1)
		{
			return u1;
		}
		return null;
	}
	@Transactional
	@Override
	public boolean addSalariedDetails(Salaried salaried)
	{
		
			salrep.save(salaried);
			return true;
	
	}

	@Transactional
	@Override
	public boolean addSelfEmployeedDetails(SelfEmployeed selfemployeed) 
	{
		
			selfemprep.save(selfemployeed);
			return true;
		
	}

	@Transactional
	@Override
	public boolean addPropertyDetails(Property property)
	{
			proprep.save(property);
			return true;
	}

	@Transactional
	@Override
	public boolean addLoanDetails(LoanApplication application) 
	{
		loanrep.save(application);
		return true;
	}

	@Override
	public User getUserInfobyId(int userId) 
	{
		Optional<User> userfind = urs.findById(userId);
		User user = null;
		if (userfind.isPresent()) {
			user = userfind.get();
		}
		
		return user;
	}

	@Override
	public List<User> getAllUsers() 
	{
		List<User> ulist=urs.findAll();
		return ulist;
	}
	@Transactional
	@Override
	public List<LoanApplication> findApplicationById(int userId) 
	{
		Query q1 = em.createQuery("Select l from LoanApplication l where USER_ID=:idd");
		q1.setParameter("idd",userId);
		List<LoanApplication> list=q1.getResultList();
		return list;
	}
	
	@Transactional
	@Override
	public List<Account> getAccountListbyAppId(int appId)
	{
		Query q1 = em.createQuery("Select a from Account a where APPLICATIONID=:appid");
		q1.setParameter("appid",appId);
		List<Account> list=q1.getResultList();
		return list;
	}

}
