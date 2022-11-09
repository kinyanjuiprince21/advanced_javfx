package models;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Country {

    private SimpleStringProperty country;
    private SimpleStringProperty capital;
    private SimpleDoubleProperty population;
    private SimpleBooleanProperty democratic;

    public Country() {
    }

    public Country(String country, String capital, Double population, Boolean democratic) {
        this.country = new SimpleStringProperty(country);
        this.capital = new SimpleStringProperty(capital);
        this.population = new SimpleDoubleProperty(population);
        this.democratic = new SimpleBooleanProperty(democratic);
    }

    public String getCountry() {
        return country.get();
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public String getCapital() {
        return capital.get();
    }

    public void setCapital(String capital) {
        this.capital.set(capital);
    }

    public Double getPopulation() {
        return population.get();
    }

    public void setPopulation(Double population) {
        this.population.set(population);
    }

    public Boolean getDemocratic() {
        return democratic.get();
    }

    public void setDemocratic(Boolean democratic) {
        this.democratic.set(democratic);
    }
}
