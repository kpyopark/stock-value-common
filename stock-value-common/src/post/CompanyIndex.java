package post;

public class CompanyIndex extends BaseStructure {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5428195949612166023L;

	/**
	 * ����������
	 */
	private float operatingProfitRatio = (float)0.0;
	
	/**
	 * ��������
	 */
	private float netProfitRatio = (float)0.0;
	
	/**
	 * �ִ� ������
	 */
	private int eps = 0;
	
	/**
	 * �ִ� ����ڻ�
	 */
	private int bps = 0;
	
	/**
	 * ���ڻ� ������
	 */
	private float roa = (float)0.0;
	
	/**
	 * �ڱ��ں� ������
	 */
	private float roe = (float)0.0;
	
	/**
	 * �ں� ������
	 */
	private float roi = (float)0.0;
	
	/**
	 * �ְ� ������
	 */
	private float per = (float)0.0;

	public int getBps() {
		return bps;
	}

	public void setBps(int bps) {
		this.bps = bps;
	}

	public int getEps() {
		return eps;
	}

	public void setEps(int eps) {
		this.eps = eps;
	}

	public float getNetProfitRatio() {
		return netProfitRatio;
	}

	public void setNetProfitRatio(float netProfitRatio) {
		this.netProfitRatio = netProfitRatio;
	}

	public float getOperatingProfitRatio() {
		return operatingProfitRatio;
	}

	public void setOperatingProfitRatio(float operatingProfitRatio) {
		this.operatingProfitRatio = operatingProfitRatio;
	}

	public float getPer() {
		return per;
	}

	public void setPer(float per) {
		this.per = per;
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

	public float getRoi() {
		return roi;
	}

	public void setRoi(float roi) {
		this.roi = roi;
	}
	
}
