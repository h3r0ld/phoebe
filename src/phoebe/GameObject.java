package phoebe;

/**
 * Az �sszes j�t�kban szerepl� j�t�kobjektum �ltal implement�lt interf�sz.
 * @author Graics Bence
 *
 */
public interface GameObject {

	/**
	 * A j�t�kobjektum interakci�j�t kezel� met�dus.
	 * @param player A Player, amelyre a j�t�kobjektum hat.
	 */
	public void interact(Player player);
	
}
