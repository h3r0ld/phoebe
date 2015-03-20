package phoebe;

public class Cell {
	
	private int i;
	
	private int j;
	
	private CellType cellType;
	
	private Player player;
	
	private GameObject gameObject;
	
	public void interact() {
        Logger.methodEntry(this);
        
        Logger.methodExit(this);
	}

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }

}
