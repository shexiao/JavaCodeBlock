package mybatis.example.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisBasic {
	public static void main(String[] args) {
		String path = "mybatis/example/basic/mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(path);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = factory.openSession();
			
			/*
			 * preferred this type
			 */
			AnimalsMapper mapper = session.getMapper(AnimalsMapper.class);
			
			List<Animals> animalslist = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				Animals animals = new Animals();
				animals.setType("cow");
				animals.setName("JJ" + i);
				animals.setId(i + 100);
				animalslist.add(animals);
			}
			
			mapper.insertlist(animalslist);
			
			/*
			 * other type
			 
			Animals animals = (Animals) session.selectOne("mybatis.example.basic.AnimalsMapper.query", 1);
			if (animals != null) {
				System.out.println(animals.toString());
			}
			*/
			session.commit();
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
