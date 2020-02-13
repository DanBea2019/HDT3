import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class JUMerge {
	@Test
	void test() {
		MainSort nuevo = new MainSort();
		ArrayList<Integer> prueba = new ArrayList<Integer>();
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		prueba.add(3);
		prueba.add(1);
		prueba.add(2);
		
		resultado.add(1);
		resultado.add(2);
		resultado.add(3);
		MainSort.mergeSort(prueba);
		assertEquals( prueba , resultado);
		
	}
}
