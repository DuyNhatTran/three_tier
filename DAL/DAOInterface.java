package DAL;

import java.util.ArrayList;

public interface DAOInterface<E> {
	
	ArrayList<E> selectAll();
	
	E selectById(E obj);
	
	int insert(E obj);

	int delete(E obj);
	
	int update(E obj);
}
