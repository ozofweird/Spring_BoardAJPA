package com.springbook.biz.board.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository("boardDAO")
public class BoardDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insertBoard(BoardVO vo) {
		em.persist(vo);
	}
	
	public void updateBoard(BoardVO vo) {
		em.merge(vo);
	}
	
	public void deletBoard(BoardVO vo) {
		em.remove(vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO) em.find(BoardVO.class, vo.getSeq());
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		TypedQuery<BoardVO> query = em.createQuery("from BoardVO b order by b.seq desc", BoardVO.class);
		return query.getResultList();
	}
}
