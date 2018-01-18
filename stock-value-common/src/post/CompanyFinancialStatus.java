package post;

public class CompanyFinancialStatus extends BaseStructure {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1397366767529694042L;
	/**
	 * ȸ������
	 */
	private Company company = null;
	/**
	 * assets : �ڻ�
	 */
	private long assets = 0;
	/**
	 * capital : �ں�
	 */
	private long capital = 0;
	/**
	 * debt : ��ä
	 */
	private long debt = 0;
	/**
	 * devidendRatio : ����� 
	 */
	private float dividendRatio = (float) 0.0;
	/**
	 * �ں��Ѱ�
	 */
	private long grossCapital = 0;
	/**
	 * ���� ������ ������ �������� ����
	 */
	private boolean isFixed = true;
	/**
	 * KOSPI ���翩��
	 */
	private boolean isKOSPI = true;
	/**
	 * ���� ������ net quarter���� ����
	 */
	private boolean isQuarter = false;
	/**
	 * netProfit : ������ 
	 */
	private long netProfit = 0;
	/**
	 * operatingProfit : �������� 
	 */
	private long operatingProfit = 0;
	/**
	 * �������
	 */
	private long ordinaryProfit = 0;
	private float roa = (float) 0.0;
	private float roe = (float) 0.0;
	private float roi = (float) 0.0;
	/**
	 * saled : �Ѹ���
	 */
	private long sales = 0;
	
	/**
	 * ��������
	 */
	private String standardDate = null;
	/**
	 * ������ ���� �ֽļ�
	 */
	private long ordinarySharesSize = 0;
	
	/**
	 * �켱�� ���� �ֽļ�
	 */
	private long prefferedSharesSize = 0;
	
	/**
	 * �����ں�
	 */
	private long investedCapital = 0;
	
	
	private boolean isCalculated = false;
	
	
	private String registeredDate = "";
	
	//
	
	public String getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = registeredDate;
	}
	public long getAssets() {
		return assets;
	}
	public void setAssets(long assets) {
		this.assets = assets;
	}
	public long getCapital() {
		return capital;
	}
	public void setCapital(long capital) {
		this.capital = capital;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public long getDebt() {
		return debt;
	}
	public void setDebt(long debt) {
		this.debt = debt;
	}
	public float getDividendRatio() {
		return dividendRatio;
	}
	public void setDividendRatio(float devidendRatio) {
		this.dividendRatio = devidendRatio;
	}
	public long getGrossCapital() {
		return grossCapital;
	}
	public void setGrossCapital(long grossCapital) {
		this.grossCapital = grossCapital;
	}
	public boolean isFixed() {
		return isFixed;
	}
	public void setFixed(boolean isFixed) {
		this.isFixed = isFixed;
	}
	public boolean isKOSPI() {
		return isKOSPI;
	}
	public void setKOSPI(boolean isKOSPI) {
		this.isKOSPI = isKOSPI;
	}
	public boolean isQuarter() {
		return isQuarter;
	}
	public void setQuarter(boolean isNetQuarter) {
		this.isQuarter = isNetQuarter;
	}
	public long getNetProfit() {
		return netProfit;
	}
	public void setNetProfit(long netProfit) {
		this.netProfit = netProfit;
	}
	public long getOperatingProfit() {
		return operatingProfit;
	}
	public void setOperatingProfit(long operatingProfit) {
		this.operatingProfit = operatingProfit;
	}
	public long getOrdinaryProfit() {
		return ordinaryProfit;
	}
	public void setOrdinaryProfit(long ordinaryProfit) {
		this.ordinaryProfit = ordinaryProfit;
	}
	public float getRoa() {
		return roa;
	}
	public void setRoa(float roa) {
		this.roa = roa;
	}
	public float getRoe() {
		return roe;
	}
	public void setRoe(float roe) {
		this.roe = roe;
	}
	public long getSales() {
		return sales;
	}
	public void setSales(long sales) {
		this.sales = sales;
	}
	public String getStandardDate() {
		return standardDate;
	}
	public void setStandardDate(String standardDate) {
		this.standardDate = standardDate;
	}
	public long getOrdinarySharesSize() {
		return ordinarySharesSize;
	}
	public void setOrdinarySharesSize(long ordinarySharesSize) {
		this.ordinarySharesSize = ordinarySharesSize;
	}
	public long getPrefferedSharesSize() {
		return prefferedSharesSize;
	}
	public void setPrefferedSharesSize(long prefferedSharesSize) {
		this.prefferedSharesSize = prefferedSharesSize;
	}
	public float getRoi() {
		return roi;
	}
	public void setRoi(float roi) {
		this.roi = roi;
	}
	public long getInvestedCapital() {
		return investedCapital;
	}
	public void setInvestedCapital(long investedCapital) {
		this.investedCapital = investedCapital;
	}
	
	
	public CompanyFinancialStatus() {
		super();
	}
	
	public CompanyFinancialStatus(BaseStructure cfs) throws Exception {
		super(cfs);
	}
	public boolean isCalculated() {
		return isCalculated;
	}
	public void setCalculated(boolean isCalculated) {
		this.isCalculated = isCalculated;
	}
}
