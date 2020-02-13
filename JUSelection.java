import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
public class JUSelection {
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
		MainSort.selectionSort(prueba);
		
		assertEquals(prueba, resultado);
	}
}
