package com.deoudegracht.deoudegracht.models;



public class Table {
    private Long ID;
    private Integer numberOfSeats;
    public Table() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
  }
