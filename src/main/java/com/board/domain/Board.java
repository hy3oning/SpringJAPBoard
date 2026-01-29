package com.board.domain;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "JPABOARD_SEQ_GEN", // 시퀀스 제너레이터 이름
		sequenceName = "JAPBOARD_SEQ", // 시퀀스이름
		initialValue = 1, // 시작값
		allocationSize = 1 // 메모리를 통해 할당할 범위 사이즈
)
@Table(name = "JPABOARD") // 데이터 베이스 테이블명 자바 클래스명과 같게했으면 없어도 상관없음
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, // 사용할 전략을 시퀀스로 선택
			generator = "JPABOARD_SEQ_GEN" // 식별자 생성기를 설정해 놓은 JPABOARD_SEQ_GEN으로 설정
	)
	@Column(name = "NO")
	private Long no;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "CONTENT")
	private String content;

	@Column(name = "WRITER")
	private String writer;

	@CreationTimestamp //SYSDATE 역할
	@Column(name = "REG_DATE")
	private Date regDate;
}
