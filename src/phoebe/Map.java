package phoebe;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private Cell[][] cells;
    
    /**
     * A Map oszt�ly konstruktora
     * @param k A m�trix sorainak a sz�ma
     * @param n A m�trix oszlopainak a sz�ma
     */
    public Map(int k, int n) {
    	for (int i = 0; i < k; ++i) {
    		for (int j = 0; j < n; ++j) {
    			cells[i][j] = new Cell(i, j, CellType.CELL_VALID, null, null);
    		}
    	}
    }
    
	/**
	 * Megadja egy adott cell�nak a szomsz�dait adott t�vols�gban.
	 * @param i Cella sorkoordin�t�ja
	 * @param j Cella oszlopkoordin�t�ja
	 * @param distance A cell�t�l val� t�vols�g
	 * @return Egy lista az adott t�vols�gban l�v� cell�kkal
	 */
	public List<Cell> getNeighbours(int i, int j, int distance) {
	    if (distance < 0 || distance > 2) {
	    	throw new IllegalArgumentException();
	    }
		List<Cell> results = new ArrayList<Cell>();
	    for (int k = -distance; k <= distance; ++k) {
	    	for (int l = -distance; l <= distance; ++l) {
	    		if (k == 0 || l == 0 || k == l || k + l == 0) 
	    		results.add(cells[i + k][j + l]);
	    	}
	    }		
	    results.remove(cells[i][j]);
		return results;
	}
	
	/**
	 * Megadja egy adott cell�nak a szomsz�dait adott t�vols�gban.
	 * @param cell A cella, amelynek a szomsz�dait szeretn�nk lek�rni
	 * @param distance A cell�t�l val� t�vols�g
	 * @return Egy lista az adott t�vols�gban l�v� cell�kkal
	 */
	public List<Cell> getNeighbours(Cell cell, int distance) {
		List<Cell> results = new ArrayList<Cell>();
		results = getNeighbours(cell.getI(), cell.getJ(), distance);
		return results;
	}
	
	/**
	 * Visszaadja a megadott koordin�t�kkal rendelkez� cell�t
	 * @param i Sorkoordin�ta
	 * @param j Oszlopkoordin�ta
	 * @return A megadott koordin�t�kkal rendelkez� cella
	 */
	public Cell getCell(int i, int j) {
		return this.cells[i][j];
	}
	
}
