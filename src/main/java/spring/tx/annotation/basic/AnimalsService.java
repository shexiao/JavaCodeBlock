package spring.tx.annotation.basic;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AnimalsService {
	public int insert();
	public int delete();
	public int update();
	public int query();
}
