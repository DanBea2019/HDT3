/*
 * Universidad del Valle de Guatemala
 * @author Daniela Batz 
 * Fecha 12/02/20
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainSort {
	public static void main(String[] args){
		
		/*
		 * Lista creada con anterioridad 
		 */
		Randoms random = new Randoms();
		
		/*
		 * Los valores Integer se localizan en una ArrayListo para el
		 * procedimiento futuro para el cual estan preparados. 
		 */
		StringBuilder sb = new StringBuilder();
        String strLine = "";
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list4 = new ArrayList<Integer>();
        
        try {
        	BufferedReader br = new BufferedReader(new FileReader("random.txt"));
        	while (strLine != null){
        		strLine = br.readLine();
        		sb.append(strLine);
        		sb.append(System.lineSeparator());
        		strLine = br.readLine();
        		if (strLine==null)
                  break;
        		list.add(Integer.valueOf(strLine));            
           }
        	System.out.println("Lista Original:\n"+list);
        	br.close();
        	} catch (FileNotFoundException e) {
        		System.err.println("File not found");
        		} catch (IOException e) {
        			System.err.println("Unable to read the file.");
        			}
        
      /*
       * Ejecuta Selection sort
       */
		selectionSort(list);
		System.out.println("\nSelection Sort List:\n"+list);
        
       /*
        * Se ejecuta el Merge Sort
        */
        mergeSort(list);
        System.out.println("\nMerge Sort List:"); //imprime la lista Sort 
        for(int p: list)
        System.out.print(p + " ");
        System.out.println();
        
        /*
         * Se ejecuta el quick sort
         */
        quicksort(list);
        System.out.println("\nQuick Sort List:\n"+list);
        
        /*
         * Se ejecuta Selection sort
         */
        selectionSort(list);
      	System.out.println("\nSelection Sort List:\n"+list);
      	
      /*
       * ejecutación del Radix Sort con la conversion del arraylist.
       * El Radix Sort es un algoritmo de ordenamiento que ordena 
       * enteros procesando sus dígitos de forma individual.
       */

      		int[] arraylist = list.stream()
      				.mapToInt(Integer::intValue)
      				.toArray();
      		orradix(arraylist); //radixsort

      		/*
      		 * Ejecutar Insertion sort
      		 */
      		insertionSort(list);

	}
	
	/*
	 * Metodo del Radix Sort
	 */
	public static void orradix(int[] arraylist) {	 
	    final int max = 10;
	    
	    @SuppressWarnings("unchecked")
		List<Integer>[] acumula = new ArrayList[max];
	    
	    for (int i = 0; i < acumula.length; i++) {
	      acumula[i] = new ArrayList<Integer>();
	    }
	    
	    boolean maxLength = false;
	    int tmp = -1, placement = 1;
	    while (!maxLength) {
	      maxLength = true;
	      
	      /*
	       * Partimos las listas
	       */
	      for (Integer i : arraylist) {
	        tmp = i / placement;
	        acumula[tmp % max].add(i);
	        if (maxLength && tmp > 0) {
	          maxLength = false;
	        }
	      }
	    
	    /*
	     * Vaciaomos las listas que se pusieron
	     * en el arreglo
	     */
	      int a = 0;
	      for (int b = 0; b < max; b++) {
	        for (Integer i : acumula[b]) {
	          arraylist[a++] = i;
	        }
	        acumula[b].clear();
	      }
	      
	      /*
	       * Correra a la siguiente casilla
	       */
	      placement *= max;
	      

	    }
	      System.out.println("\nRadix Sort");
	      ArrayList<Integer> print = new ArrayList<>() ;
	      for(int i = 0; i < arraylist.length; i++) {
	    	  int tempt = arraylist[i];
	    	  print.add(tempt);
	      }
	      System.out.println(print);
	}
 

	/*
	 * Empieza el Quick Sort
	 */
	public static void quicksort(ArrayList<Integer> list ) {
		/*
		 * Se llama al metodo asignando la lista
		 */
		doquickSort( list, 0, list.size()-1 ); 
	}
	private static void doquickSort( ArrayList<Integer> list, int low, int high )
	{
		int pivot;

		if( low >= high )
			return;
		/*
		 * Se parte la lista y se crea un metodo recursivo 
		 */
		pivot = split( list, low, high );
		doquickSort( list, low, pivot-1 );
		doquickSort( list, pivot+1, high );
	}

	/*
	 * Dividimos la lista en varias partes similares
	 */
	private static int split( ArrayList<Integer> list, int low, int high ){
		int pivotVal = list.get( low );
		int right = high;
		int left = low + 1;

		while( left <= right ){
        /*
         * Mueve los valores a la derecha hasta que se obtiene el valor que es mayor 
         */
        while( left <= high && list.get(left) <= pivotVal )
        	left++;

        /*
         * Mueve los valores a la izquierda hasta que se obtiene el valor que es menor
         */
        while( list.get(right) > pivotVal )
            right--;

        /*
         * Reajuste y ordenamiento de posiciones 
         */
        if( left < right ){
        	intercambio( list, left, right );
            left++;
            right--;
        }
    }

    /*
     * Realizamos intercambio
     */
    intercambio( list, low, right );
    
    // right contains the pivot value
    return right;
}

	/*
	 * Realizar intercambio y ordenamiento dentro del ArrayList
	 */
	private static void intercambio( ArrayList<Integer> list, int i, int j ){
		int tempt = list.get(i);
		list.set( i, list.get(j) );
		list.set( j, tempt );
	}
	
	/*
	 * SELECTION SORT
	 */
	public static void selectionSort(ArrayList<Integer> list) {

		/*
		 * Comprobacion de si lista esta vacia
		 */
		if (list == null)
			return;

		/*
		 *  Comprobacion para ver si esta vacia o contiene unicamente un elemento
		 */
		if (list.size() == 0 || list.size() == 1)
			return;
		
		int menorcasilla;

		int menor;

		/*
		 * iclo para corrborar cada espacio de la lista
		 */
		for (int index = 0; index < list.size(); index++) {

			/*
			 * Obtener y comprobar el numero mas pequeño
			 */
			menor = list.get(index);
			menorcasilla = index;

			for (int i = index + 1; i < list.size(); i++) {
				if (menor > list.get(i)) {
					
					menor = list.get(i); //Asigna el valor menor
					menorcasilla = i;
				}
			}

			/*
			 * Ordenar el valor
			 */
			if (menorcasilla == index)
				;
			
			else {
				int tempt = list.get(index);
				list.set(index, list.get(menorcasilla));
				list.set(menorcasilla, tempt);
			}

		}
	}
	
	/*
	 * METODO MERGE SORT
	 */
	public static void mergeSort(ArrayList<Integer>list){
		  doMergeSort(list); //se llama al metodo domergesort con la lista asignada para encapsulacion.
		}

		private static void doMergeSort(ArrayList<Integer> list){ 
		  int middle; //mitad del arreglo
		  ArrayList<Integer> left = new ArrayList<>(); // Lista izquierda
		  ArrayList<Integer> right = new ArrayList<>(); // Lista derecha
		  
		  if (list.size() > 1) {
		     middle = list.size() / 2;
		        /*
		         * La mitad izquierda se asigna a la izquierda
		         */
		        for (int i = 0; i < middle; i++) 
		            left.add(list.get(i));
		 
		        /*
		         * Ltad derecha se asigna a la derecha
		         */
		        for (int j = middle; j < list.size(); j++)
		            right.add(list.get(j));
		            
		     doMergeSort(left); //metodo  para multiples iteraciones (mitad izquierda)
		     doMergeSort(right); //metodo  para multiples iteraciones (mitad derecha)
		     
		     merge(list, left, right); //metodo para multiples iteraciones y union de la lista
		  }
		}

		private static void merge(ArrayList<Integer> list, ArrayList<Integer> left, ArrayList<Integer> right){
		  /*
		   * Una lista temporal para la asignacion de variables y su ordenamiento
		   */
		  ArrayList<Integer> tempt = new ArrayList<>(); 
		  
		  /*
		   * Declaracion de las variables
		   */
		  int listIndex = 0;    
		  int leftIndex = 0;
		  int rightIndex = 0;
		  
		  /*
		   * Ciclo para ordenamiento con condicionales y asignacion de valores en el temporal
		   */
		  while (leftIndex < left.size() && rightIndex < right.size()) {
		    if (left.get(leftIndex) < right.get(rightIndex) ) {
		            list.set(listIndex, left.get(leftIndex));
		            leftIndex++;
		        } else {
		            list.set(listIndex, right.get(rightIndex));
		            rightIndex++;
		        }
		        listIndex++;
		    }
		   
		    int tempIndex = 0;
		    if (leftIndex >= left.size()) {
		        tempt = right;
		        tempIndex = rightIndex;
		    } 
		    else {
		        tempt = left;
		        tempIndex = leftIndex;
		    }
		 
		    for (int i = tempIndex; i < tempt.size(); i++) {
		        list.set(listIndex, tempt.get(i));
		        listIndex++;
		    } 
		 }
	
		/*
		 * METODO INSERTION SORT
		 */
	public static void insertionSort(ArrayList<Integer> list ){
	
	/*
	 * Asignación de variables
	 */
    int valor;
    int posicion;
    
    /*
     * Una condicional para ordenamiento en cada iteracion
     */
    for( int i=1; i<list.size(); i++ ){
        /*
         * Asignar el valor
         */
        valor = list.get(i);
        
        /*
         * La posicion inicial
         */
        posicion = i;
        
        /*
         * Mover posicion para insercion a la izquierda hasta que termine el arreglo
         */
        while( posicion > 0 && list.get(posicion-1) > valor ){
            /*
             *  mover a la izquierda
             */
            list.set( posicion, list.get(posicion-1) );
            posicion--;
        }
        
        /*
         * Copiar el valor
         */
        list.set(posicion, valor );
        
    	}
    System.out.println("\nInsertion Sort:\n" + list);
    }
}
