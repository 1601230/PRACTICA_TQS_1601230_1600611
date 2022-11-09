package Controller;

public class Box {
    private boolean mine = false;
    private boolean open = false;
    private String content = " ";

    public boolean getMine()
    {
        return mine;
    }
    public boolean getOpen()
    {
        return open;
    }
    public String getContent() { return content; }
    public void setMine(boolean mine)
    {
        this.mine = mine;
    }
    public void setOpen(boolean open)
    {
        this.open = open;
    }
    public void setContent(String content) { this.content = content; }
}
