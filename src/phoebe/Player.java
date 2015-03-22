package phoebe;

import java.util.HashMap;

public class Player {

    private int idx = -1;
    
    private Cell initialPosition = new Cell();
    
    private boolean canChangeDirection = true;
    
    private int speed = 2;
    
    private HashMap<String, Integer> storedStains = new HashMap<String, Integer>();
    
    private Cell currentCell = new Cell();
        
    /*
     * Player konstruktora, amely egy cell�t kap.
     * Az aktu�lis cell�t �t�ll�tja a kapott cell�ra.
     * L�trehozza a HashMap-et, amiben t�roljuk, hogy melyik foltb�l mennyi van.
     */
    public Player(Cell cell) {
    	currentCell = cell;
    	
    	storedStains.put(OilStain.class.getName(), 3);    	
    	storedStains.put(GlueStain.class.getName(), 3);
    }
    
    /*
     * Visszaadja a kezd�poz�ci�t.
     */
    public Cell getInitialPosition() {    	
    	return initialPosition;
    }
    
    /*
     * Kezd�poz�ci� be�ll�t�sa.
     */
    public void setInitialPosition(Cell init) {
    	Logger.methodEntry(this, init.toString());
    	
    	this.initialPosition = init;
    	
    	Logger.methodExit(this);
    }
    
    /*
     * Visszat�r azzal a cell�val, amin �ppen �ll a j�t�kos.
     */
    public Cell getCurrentCell() {    	
    	return currentCell;
    }
    
    /*
     * �tl�pteti a j�t�kost a param�terk�nt �tvett cell�ra.
     */

    public Player(int idx) {
        Logger.methodEntry(this, Integer.toString(idx));
        this.idx = idx;        
        Logger.methodExit(this);
    }
    
    public void move(Cell cell) {
        Logger.methodEntry(this, cell.toString());
        
        this.currentCell.setPlayer(null);
        
        this.currentCell = cell;
        this.currentCell.setPlayer(this);
                
        Logger.methodExit(this);
    }
    
    /*
     * Olaj- vagy ragacsfolt lerak�sa.
     */
    public void putStain(String stainType) {
        Logger.methodEntry(this, stainType);        
        
        if(stainType.equals(GlueStain.class.getName())) {
        	GlueStain glueStain = new GlueStain();
        	
        	getCurrentCell().setGameObject(glueStain);
        }
        
        if(stainType.equals(OilStain.class.getName())) {
        	OilStain oilStain = new OilStain();
        	
        	getCurrentCell().setGameObject(oilStain);
        }                 
       
        Logger.methodExit(this);        
    }
    
    /*
     * Alaphelyzetbe �ll�tja a foltk�szletet.
     */
    public void resetStainCount() {
        Logger.methodEntry(this);

        storedStains.put(OilStain.class.getName(), 3);      
        storedStains.put(GlueStain.class.getName(), 3);
        
        Logger.methodExit(this);        
    }
    
    /*
     * Megh�vja annak a cell�nak az interact() met�dus�t, amelyiken tart�zkodik.
     */
    public void onTurnStart() {
        Logger.methodEntry(this);
        
        this.getCurrentCell().interact();
                
        Logger.methodExit(this);        
    }
    
    /*
     * A k�r v�g�n vissza�ll�tja a mozgathat�s�got, �s a sebess�get.
     * (Elt�vol�tja az el�z� k�rben felvett foltok hat�s�t.)
     */
    public void onTurnEnd() {
        Logger.methodEntry(this);
        
        //alaphelyzetbe �ll�tja a sebess�get
        this.setSpeed(2);
        
        //alaphelyzetbe �ll�tja a mozgathat�s�g�t
        this.setCanChangeDirection(true);
                
        Logger.methodExit(this);        
    }
    
    /*
     * Megadja a kezd�pontt�l megtett t�vols�got.
     */
    public int getDistance() {
        return 
                Math.abs(this.initialPosition.getX() - this.currentCell.getX())
                    +
                Math.abs(this.initialPosition.getY() - this.currentCell.getY());
    }
    
    /*
     * A j�t�k �jraind�t�sa.
     * Alaphelyzetbe �ll�tja a foltk�szletet.
     * Enged�lyezi az ir�nyv�ltoztat�s�t.
     * Alap�rt�kre �ll�tja a sebess�get.
     */
    public void reset() {
        Logger.methodEntry(this);
        
        this.resetStainCount();
        
        this.setCanChangeDirection(true);
        
        this.setSpeed(2);
                
        Logger.methodExit(this);        
    }
    
    @Override
    public String toString() {
        return "[" + this.getClass().getName() + "](id=" + this.idx + ")";
    }

    /*
     * Visszat�r azzal, hogy a j�t�kos mozgathatja-e a robot.
     */
    public boolean isCanChangeDirection() {    	
        return canChangeDirection;
    }

    /*
     * Azt �ll�tja be, hogy az adott j�t�kos tudja-e ir�ny�tani a robotot.
     */
    public void setCanChangeDirection(boolean canChangeDirection) {
    	Logger.methodEntry(this, Boolean.toString(canChangeDirection));
    	
    	this.canChangeDirection = canChangeDirection;
        
        Logger.methodExit(this);
    }

    /*
     * Visszat�r a j�t�kos sebess�g�vel.
     */
    public int getSpeed() {    	
        return this.speed;
    }

    /*
     * A param�terk�nt kapott �rt�ket be�ll�tja a j�t�kos sebess�g�re.
     */
    public void setSpeed(int speed) {
       Logger.methodEntry(this, Integer.toString(speed));
       
       this.speed = speed;
       
       Logger.methodExit(this);    	
    }

    public void setCurrentCell(Cell cell) {
    	currentCell = cell;
    }
    
    public int getIdx() {
        return this.idx;
    }
}
