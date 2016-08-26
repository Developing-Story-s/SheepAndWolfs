class Array2D<E>{
    java.util.List<E> underlying;
    int width;
    int height;
	public Array2D(int width, int height){
		this.width = width;
		this.height = height;
		underlying = new java.util.ArrayList<E>(width * height);
	}
	public void addAt(int i, int j, E elt){
	  underlying.add(i*width + j,elt);
	}

	public E getFrom(int i, int j){
		return underlying.get(i*width + j);
	}
}