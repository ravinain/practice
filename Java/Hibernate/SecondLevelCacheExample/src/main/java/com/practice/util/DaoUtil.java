package com.practice.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import com.practice.bo.Employee;

public class DaoUtil {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		System.out.println("Temp Dir:" + System.getProperty("java.io.tmpdir"));

		// Initialize Sessions
		final SessionFactory sessionFactory = HibernateUtil.INSTANCE
				.getSessionFactory();
		final Statistics stats = sessionFactory.getStatistics();
		System.out.println("Stats enabled=" + stats.isStatisticsEnabled());
		stats.setStatisticsEnabled(true);
		System.out.println("Stats enabled=" + stats.isStatisticsEnabled());

		final Session session = sessionFactory.openSession();
		final Session otherSession = sessionFactory.openSession();
		final Transaction transaction = session.beginTransaction();
		final Transaction otherTransaction = otherSession.beginTransaction();

		printStats(stats, 0);

		Employee emp = (Employee) session.load(Employee.class, 1);
		printData(emp, stats, 1);

		emp = (Employee) session.load(Employee.class, 1);
		printData(emp, stats, 2);

		// clear first level cache, so that second level cache is used
		session.evict(emp);
		emp = (Employee) session.load(Employee.class, 1);
		printData(emp, stats, 3);

		emp = (Employee) session.load(Employee.class, 3);
		printData(emp, stats, 4);

		emp = (Employee) otherSession.load(Employee.class, 1);
		printData(emp, stats, 5);

		// Release resources
		transaction.commit();
		otherTransaction.commit();
		sessionFactory.close();
	}

	private static void printStats(final Statistics stats, final int i) {
		System.out.println("***** " + i + " *****");
		System.out.println("Fetch Count=" + stats.getEntityFetchCount());
		System.out.println("Second Level Hit Count="
				+ stats.getSecondLevelCacheHitCount());
		System.out.println("Second Level Miss Count="
				+ stats.getSecondLevelCacheMissCount());
		System.out.println("Second Level Put Count="
				+ stats.getSecondLevelCachePutCount());
	}

	private static void printData(final Employee emp, final Statistics stats,
			final int count) {
		System.out.println("Employee : " + emp);
		System.out.println(count + ":: Name=" + emp.getName());
		printStats(stats, count);

	}

}
