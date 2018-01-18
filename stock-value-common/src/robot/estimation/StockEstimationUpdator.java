package robot.estimation;

import java.util.ArrayList;

import post.Company;
import post.CompanyEx;
import post.KrxSecurityType;
import post.StockEstimated;
import robot.DataUpdator;
import common.PeriodUtil;
import common.StringUtil;
import dao.CompanyExDao;
import dao.CompanyStockEstimationDao;
import estimator.StockValueEstimator;

/**
 * ����Ǿ� �ִ� �ֽ������� Ȱ���Ͽ� ���� �ڷḦ �����Ѵ�.
 * 
 * @author Administrator
 *
 */
public class StockEstimationUpdator extends DataUpdator {
	
	ArrayList<CompanyEx> companyList = null;
	String standardDate = null;
	
	public StockEstimationUpdator() {
		this(StringUtil.convertToStandardDate(new java.util.Date()));
	}
	
	public StockEstimationUpdator(String standardDate) {
		this.standardDate = standardDate;
		init();
	}
	
	public void init() {
		try {
			CompanyExDao dao = new CompanyExDao();
			companyList = dao.selectAllList(this.standardDate, KrxSecurityType.STOCK);
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	public StockEstimated estimate(Company company, String registeredDate) {
		StockValueEstimator estimator = new StockValueEstimator(registeredDate);
		StockEstimated cse = estimator.caculateCompanyStockEstimation(company);
		return cse;
	}
	
	public void updateAllStockEstimation() {
		for(Company company:companyList) {
			updateStockEstimated(company, StringUtil.convertToStandardDate(new java.util.Date()));
		}
	}

	/**
	 * 
	 * �ְ� �߻�ġ ������ �����Ѵ�.
	 * 
	 * @param cse
	 * @return
	 */
	public int updateStockEstimated(Company company, String registeredDate) {
		CompanyStockEstimationDao stockEstimDao = new CompanyStockEstimationDao();
		StockEstimated cse = estimate(company, registeredDate);
		Throwable err = null;
		int totCnt = 0;
		try {
			if ( stockEstimDao.select(cse.getCompany(), registeredDate ) != null ) {
				stockEstimDao.delete(cse);
			}
			totCnt = stockEstimDao.insert(cse) ? 1 : 0;
		} catch ( Exception e ) {
			System.out.println("updateStockEstimated failed:" + company.getId() + ":" + company.getName() + ":" + registeredDate);;
			err = e;
		}
		fireStockEstimationChanged(cse, err);
		return totCnt;
	}

	public static void main(String[] args) {
		updateAllStockAndPeriods();
	}
	
	public static void testStockEsitmation() {
		try {
			StockEstimationUpdator updator = new StockEstimationUpdator();
			Company company = new Company();
			company.setId("A006390");
			updator.updateStockEstimated(company, StringUtil.convertToStandardDate(new java.util.Date()));
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	public static void updateAllStockAndPeriods() {
		ArrayList<String> monthlyPeriods = PeriodUtil.getMonthlyPeriodList(2003, 2014);

		CompanyExDao companyDao = new CompanyExDao();
		try {
			for( String monthString : monthlyPeriods ) {
				ArrayList<CompanyEx> companies = companyDao.selectAllList(monthString, KrxSecurityType.STOCK);
				StockEstimationUpdator updator = new StockEstimationUpdator();
				for( Company company : companies ) {
					System.out.println("update stock esitmated:" + company.getId() + ":" + company.getName() + ":" + monthString );
					updator.updateStockEstimated(company, monthString);
				}
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
}
