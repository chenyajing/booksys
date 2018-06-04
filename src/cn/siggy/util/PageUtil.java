package cn.siggy.util;

public class PageUtil {
	private int totalPage;
	private int pageSize;
	private int  totalCount;
	private int currentPage;
	public int getTotalPage() {
		return totalPage = totalCount%pageSize==0?(totalCount/pageSize):(totalCount/pageSize + 1);
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
}
