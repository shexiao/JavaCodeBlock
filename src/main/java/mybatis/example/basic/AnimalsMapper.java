package mybatis.example.basic;

import java.util.List;

public interface AnimalsMapper {
	public int insert(Animals animals);
	public int update(int id);
	public int delete(int id);
	public Animals query(int id);
	public int insertlist(List<Animals> list);
}
