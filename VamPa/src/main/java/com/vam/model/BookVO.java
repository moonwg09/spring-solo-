package com.vam.model;

import java.util.Date;

public class BookVO {
	
	/* ��ǰ id */
	private int bookId;
	
	/* ��ǰ �̸� */
	private String bookName;
	
	/* �۰� id */
	private int authorId;
	
	/* �۰� �̸� */
	private String authorName;
	
	/* ������ */
	private String publeYear;
	
	/* ���ǻ� */
	private String publisher;
	
	/* ī�װ� �ڵ� */
	private String cateCode;
	
	/* ī�װ� �̸� */
	private String cateName;
	
	/* ��ǰ ���� */
	private int bookPrice;
	
	/* ��ǰ ��� */
	private int bookStock;
	
	/* ��ǰ ���η�(�����) */
	private double bookDiscount;
	
	/* ��ǰ �Ұ� */
	private String bookIntro;
	
	/* ��ǰ ���� */
	private String bookContents;
	
	/* ��� ��¥ */
	private Date regDate;
	
	/* ���� ��¥ */
	private Date updateDate;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPubleYear() {
		return publeYear;
	}

	public void setPubleYear(String publeYear) {
		this.publeYear = publeYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getBookStock() {
		return bookStock;
	}

	public void setBookStock(int bookStock) {
		this.bookStock = bookStock;
	}

	public double getBookDiscount() {
		return bookDiscount;
	}

	public void setBookDiscount(double bookDiscount) {
		this.bookDiscount = bookDiscount;
	}

	public String getBookIntro() {
		return bookIntro;
	}

	public void setBookIntro(String bookIntro) {
		this.bookIntro = bookIntro;
	}

	public String getBookContents() {
		return bookContents;
	}

	public void setBookContents(String bookContents) {
		this.bookContents = bookContents;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "BookVO [bookId=" + bookId + ", bookName=" + bookName + ", authorId=" + authorId + ", authorName="
				+ authorName + ", publeYear=" + publeYear + ", publisher=" + publisher + ", cateCode=" + cateCode
				+ ", cateName=" + cateName + ", bookPrice=" + bookPrice + ", bookStock=" + bookStock + ", bookDiscount="
				+ bookDiscount + ", bookIntro=" + bookIntro + ", bookContents=" + bookContents + ", regDate=" + regDate
				+ ", updateDate=" + updateDate + "]";
	}
	
	
		
		

}
