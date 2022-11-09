package Controller;

public class Box {
    private boolean mine = false;
    private boolean open = false;
    private String content = " ";

    public boolean getMine()
    {
        return true;
    }
    public boolean getOpen()
    {
        return true;
    }
    public String getContent() { return "?"; }
    public void setMine(boolean mine)
    {
        mine = mine;
    }
    public void setOpen(boolean open)
    {
        open = open;
    }
    public void setContent(String content) { content = content; }
}
