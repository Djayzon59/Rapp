package model;

public class Client {


    private int id_client;
    private String denominationSociale;
    private String mailClient;
    private String numeroRueCLient;
    private String libelleRueClient;
    private String complementAdresseClient;
    private String codePostalClient;
    private String numeroTva;
    private String numTelClient;
    private String password;
    private Role role;
    private Ville ville;


    public Client() {
        role = new Role();
    }

    public Client(String denominationSociale, String mailClient, String numeroRueCLient, String libelleRueClient, String complementAdresseClient, String codePostalClient, String numeroTva, String numTelClient, String password) {
        this.denominationSociale = denominationSociale;
        this.mailClient = mailClient;
        this.numeroRueCLient = numeroRueCLient;
        this.libelleRueClient = libelleRueClient;
        this.complementAdresseClient = complementAdresseClient;
        this.codePostalClient = codePostalClient;
        this.numeroTva = numeroTva;
        this.numTelClient = numTelClient;
        this.password = password;
    }

    public Client(String denominationSociale, String mailClient, String numeroRueCLient, String libelleRueClient, String complementAdresseClient, String codePostalClient, String numeroTva, String numTelClient, String password, Role role, Ville ville) {
        this.denominationSociale = denominationSociale;
        this.mailClient = mailClient;
        this.numeroRueCLient = numeroRueCLient;
        this.libelleRueClient = libelleRueClient;
        this.complementAdresseClient = complementAdresseClient;
        this.codePostalClient = codePostalClient;
        this.numeroTva = numeroTva;
        this.numTelClient = numTelClient;
        this.password = password;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getDenominationSociale() {
        return denominationSociale;
    }

    public void setDenominationSociale(String denominationSociale) {
        this.denominationSociale = denominationSociale;
    }

    public String getMailClient() {
        return mailClient;
    }

    public void setMailClient(String mailClient) {
        this.mailClient = mailClient;
    }

    public String getNumeroRueCLient() {
        return numeroRueCLient;
    }

    public void setNumeroRueCLient(String numeroRueCLient) {
        this.numeroRueCLient = numeroRueCLient;
    }

    public String getLibelleRueClient() {
        return libelleRueClient;
    }

    public void setLibelleRueClient(String libelleRueClient) {
        this.libelleRueClient = libelleRueClient;
    }

    public String getComplementAdresseClient() {
        return complementAdresseClient;
    }

    public void setComplementAdresseClient(String complementAdresseClient) {
        this.complementAdresseClient = complementAdresseClient;
    }

    public String getCodePostalClient() {
        return codePostalClient;
    }

    public void setCodePostalClient(String codePostalClient) {
        this.codePostalClient = codePostalClient;
    }

    public String getNumeroTva() {
        return numeroTva;
    }

    public void setNumeroTva(String numeroTva) {
        this.numeroTva = numeroTva;
    }

    public String getNumTelClient() {
        return numTelClient;
    }

    public void setNumTelClient(String numTelClient) {
        this.numTelClient = numTelClient;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return  denominationSociale;
    }
}
