package io.tobias.palatinehuts.model;

public enum Assocation {

    PWV("Pfälzerwaldverein e.V."),
    NFH("Natufreunde");

    private String assocation;

    Assocation(String ass) {
        this.assocation = ass;
    }

    public String getAssocation() {
        return this.assocation;
    }


}
