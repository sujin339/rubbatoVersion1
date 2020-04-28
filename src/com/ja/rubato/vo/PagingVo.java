package com.ja.rubato.vo;

public class PagingVo {
	
	private int contentTotalCount;
	private int currentPage;
	private int totalPage;
	
	private int displayPage = 5;
	private int displayRow = 10;
	private int beginPage;
	private int endPage;
	
	public PagingVo() {
		super();
	}

	public PagingVo(int contentTotalCount, int currentPage, int totalPage, int displayPage, int displayRow,
			int beginPage, int endPage) {
		super();
		this.contentTotalCount = contentTotalCount;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.displayPage = displayPage;
		this.displayRow = displayRow;
		this.beginPage = beginPage;
		this.endPage = endPage;
	}

	public int getContentTotalCount() {
		return contentTotalCount;
	}

	public void setContentTotalCount(int contentTotalCount) {
		this.contentTotalCount = contentTotalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getDisplayPage() {
		return displayPage;
	}

	public void setDisplayPage(int displayPage) {
		this.displayPage = displayPage;
	}

	public int getDisplayRow() {
		return displayRow;
	}

	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	
	

}
