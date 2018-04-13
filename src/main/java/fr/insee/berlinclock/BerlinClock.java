package fr.insee.berlinclock;

public class BerlinClock {

    /**
     * remplissage de la première ligne de l'horloge.
     * 
     * @param hours:
     *            l'heure pour laquelle on veut récupérer la premier colonne
     * @return une chaine de 4 caractères représentant le nombre de 5 heure dans
     *         hours. La chaine retournée est de la forme "RROO" avec R case
     *         remplie, et O case vide.
     * @throws IllegalArgumentException
     *             si hours n'est pas compris entre 0 et 24
     */
    public String getTopHours(int hours) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Pas implémenté");
    }

    /**
     * remplissage de la deuxième ligne de l'horloge.
     * 
     * @param hours:
     *            l'heure pour laquelle on veut récupérer la deuxième colonne
     * @return une chaine de 4 caractères représentant le nombre d'heure. La
     *         chaine retournée est de la forme "RROO" avec R case remplie, et O
     *         case vide.
     * @throws IllegalArgumentException
     *             si hours n'est pas compris entre 0 et 24
     */
    public String getBottomHours(int hours) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Pas implémenté");
    }

    /**
     * remplissage de la troisième ligne de l'horloge.
     * 
     * @param minutes:
     *            le nombre de minutes pour lequel on veut récupérer la deuxième
     *            colonne
     * @return une chaine de 11 caractères représentant le nombre de 5 minutes
     *         dans minutes. La chaine retournée est de la forme "YYRYYROOOOO"
     *         avec R case remplie en rouge, Y case remplie en jaune et O case
     *         vide.
     * @throws IllegalArgumentException
     *             si minutes n'est pas compris entre 0 et 60
     */
    public String getTopMinutes(int minutes) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Pas implémenté");
    }

    /**
     * remplissage de la troisième ligne de l'horloge.
     * 
     * @param minutes:
     *            le nombre de minutes pour lequel on veut récupérer la deuxième
     *            colonne
     * @return une chaine de 4 caractères représentant le nombre de minutes de
     *         la dernière ligne. La chaine retournée est de la forme "YYOO" Y
     *         case remplie en jaune et O case vide.
     * @throws IllegalArgumentException
     *             si minutes n'est pas compris entre 0 et 60
     */
    public String getBottomMinutes(int minutes) throws IllegalArgumentException{
        throw new UnsupportedOperationException("Pas implémenté");
    }

    
    /**
     * donne la représentation d'une heure complète
     * 
     * @param Une chaine de caractères au format 'HH:mm' représentant l'heure à afficher
     * @return un tableau de 4 String représentant les 4 lignes de l'horloge. 
     */
    public String[] convertToBerlinTime(String string) throws IllegalArgumentException{
        throw new UnsupportedOperationException("Pas implémenté");
    }

}
