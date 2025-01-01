package com.tech.im.vo;

import lombok.Getter;

@Getter
public class ImPostPageVO {
    private int currentPage; // 현재 페이지
    private int totalPages; // 전체 페이지 수
    private int startPage; // 페이지 네비게이션의 시작 페이지
    private int endPage; // 페이지 네비게이션의 끝 페이지

    public ImPostPageVO(int currentPage, int totalPost, int postPerPage) {
        this.currentPage = currentPage;

        // 전체 페이지 수 계산
        this.totalPages = (int) Math.ceil((double) totalPost / postPerPage);

        // 페이지 네비게이션 계산 (한 블록에 10페이지 표시)
        int pageBlock = 10;
        this.startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;
        this.endPage = Math.min(this.startPage + pageBlock - 1, this.totalPages);
    }
}
