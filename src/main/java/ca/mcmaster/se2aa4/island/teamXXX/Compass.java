package ca.mcmaster.se2aa4.island.teamXXX;

public enum Compass 
{
    NORTH, WEST, SOUTH, EAST, NONE;

   
    public Compass right(){
        switch(this){
            case NORTH: return Compass.EAST;
            case WEST: return Compass.NORTH;
            case SOUTH: return Compass.WEST;
            case EAST: return Compass.SOUTH;
            default: return this;
        }
    }

    
    public Compass left(){
        switch(this){
            case NORTH: return Compass.WEST;
            case WEST: return Compass.SOUTH;
            case SOUTH: return Compass.EAST;
            case EAST: return Compass.NORTH;
            default: return this;
        }
    }

    
    public Compass opposite(){
        switch(this){
            case NORTH: return Compass.SOUTH;
            case WEST: return Compass.EAST;
            case SOUTH: return Compass.NORTH;
            case EAST: return Compass.WEST;
            default: return this;
        }
    }

 
    public String CompasToString(){
        switch(this){
            case NORTH: return "N";
            case WEST: return "W";
            case SOUTH: return "S";
            case EAST: return "E";
            default: return "";
        }
    }

 
    public Compass StringToCompass(String heading){
        switch(heading){
            case "N": return Compass.NORTH;
            case "W": return Compass.WEST;
            case "S": return Compass.SOUTH;
            case "E": return Compass.EAST;
            default: return Compass.NORTH;
        }
    }
}