package com.raidencentral.hello;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.raidencentral.persistence.HibernateUtil;

public class HelloWorld {
	public static void main(String[] args) {

		// First unit of work
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Message message = new Message("Hello World");
		Long msgId = (Long) session.save(message);
		System.out.println("%%% msgId is"+msgId);

		tx.commit();
		session.close();

		// Second unit of work
		Session newSession = HibernateUtil.getSessionFactory().openSession();
		Transaction newTransaction = newSession.beginTransaction();

		List messages = newSession.createQuery("from Message m order by m.text asc").list();
		System.out.println("%%% "+messages.size() + " messages found:");
		for (Iterator iter = messages.iterator(); iter.hasNext();) {
			Message loadedMessage = (Message) iter.next();
			System.out.println(loadedMessage.getText());
		}
		newTransaction.commit();
		newSession.close();

		// shutting down the application
		HibernateUtil.shutdown();

	}
}
