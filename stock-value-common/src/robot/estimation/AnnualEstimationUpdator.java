package robot.estimation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import post.Company;
import post.CompanyEx;
import post.CompanyFinancialStatusEstimated;
import post.KrxSecurityType;
import robot.DataUpdator;
import common.PeriodUtil;
import common.StringUtil;
import dao.CompanyExDao;
import dao.CompanyFinancialEstimStatusDao;

/**
 * CompanyListUpdator �������� ������ �б������� ���� �ϳⰣ�� �����ڷḦ �����Ѵ�.
 * 
 * @author Administrator
 *
 */
public class AnnualEstimationUpdator extends DataUpdator {
	
	CompanyFinancialEstimStatusDao estimDao = null;
	
	public AnnualEstimationUpdator() throws SQLException {
		estimDao = new CompanyFinancialEstimStatusDao();
	}
	
	/**
	 * ��ü ������� ����� ���ʷ�
	 * �߻�ġ�� ����Ѵ���
	 * �߻�ġ ���̺��� update�Ѵ�.
	 * 
	 * @throws SQLException
	 */
	public void updateCompanyFinancialStatusEstimated(Company company, String registeredDate) throws SQLException {
		CompanyFinancialStatusEstimated estimatedCfs = estimDao.updateFinancialReportEstimated(company, registeredDate);
		fireCompanyFinancialStatusEstimatedChanged(estimatedCfs, null);
	}
	
	public void updateAllFinancialReportEstimated() {
		CompanyExDao companyDao = new CompanyExDao();
		ArrayList<String> periodsList = PeriodUtil.getQuarterListFrom2000ToNow();
		try {
			for ( String period : periodsList ) {
				ArrayList<CompanyEx> companies = companyDao.selectAllList(period, KrxSecurityType.STOCK);
				for ( Company company : companies ) {
					estimDao.updateFinancialReportEstimated(company, period);
				}
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//testUpdateAllFinancialEstimated();
		testUpdateFinancialEstimated();
	}
	
	public static void testUpdateAllFinancialEstimated() {
		try {
			AnnualEstimationUpdator updator = new AnnualEstimationUpdator();
			updator.addUpdateListener(new robot.listenter.ExamUpdateListener());
			updator.updateAllFinancialReportEstimated();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	public static void testUpdateFinancialEstimated() {
		try {
			AnnualEstimationUpdator updator = new AnnualEstimationUpdator();
			updator.addUpdateListener(new robot.listenter.ExamUpdateListener());
			Company company = new Company();
			company.setId("A034730");
			updator.updateCompanyFinancialStatusEstimated(company, StringUtil.convertToStandardDate(new Date()));
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	

}
