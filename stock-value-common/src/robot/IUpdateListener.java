package robot;

import post.CompanyEx;
import post.CompanyFinancialStatus;
import post.CompanyFinancialStatusEstimated;
import post.Stock;
import post.StockEstimated;

public interface IUpdateListener {

	/**
	 * �ְ��� ����Ǿ��� ��� �˷���. 
	 * 
	 * @param stock
	 * @param err
	 */
	public void stockValueChanged(Stock stock, Throwable err);
	
	/**
	 * �ְ��� ���� �̷��߻�ġ�� ����Ǿ��� ��� �˷���.
	 * 
	 * @param cse
	 * @param err
	 */
	public void stockEstimationChanged(StockEstimated cse, Throwable err);
	
	/**
	 * ȸ�� ��ü�� ���� ������ ����Ǿ��� ���(�̸��� ����Ǿ��ų�, ����, �Ǵ� �����Ǿ��� ���)
	 * @param company
	 * @param err
	 */
	public void companyChanged(CompanyEx company, Throwable err);
	
	/**
	 * ȸ���� �繫��ǥ�� ����Ǿ��� ��� �˷���.
	 * @param cfs
	 * @param err
	 */
	public void companyFinancialStatusChanged(CompanyFinancialStatus cfs, Throwable err);
	
	/**
	 * ȸ���� �繫��ǥ �߻�ġ�� ����Ǿ��� ��� �˷���.
	 * @param cfe
	 * @param err
	 */
	public void companyFinancialStatusEstimatedChanged(CompanyFinancialStatusEstimated cfe, Throwable err);
	
}
