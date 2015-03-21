package phoebe;

public abstract class Stain implements GameObject {

	/**
	 * Absztrakt met�dus az egyes Stain-ek interakci�ira.
	 * @param A Player, amelyre a cella hat.
	 */
	public abstract void interact(Player player);

}
