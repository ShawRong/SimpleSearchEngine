package hust.cs.javacourse.search.index.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import hust.cs.javacourse.search.index.AbstractPosting;
import hust.cs.javacourse.search.index.AbstractPostingList;

public class PostingList extends AbstractPostingList{

	@Override
	public void writeObject(ObjectOutputStream out) {
		try {
			out.writeObject(this.list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readObject(ObjectInputStream in) {
		try {
			this.list = (List<AbstractPosting>)in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void add(AbstractPosting posting) {
		posting.sort();
		if(this.list != null && !this.list.contains(posting)) {
			this.list.add(posting);
		}
	}

	@Override
	public String toString() {
		String ret;
		if(this.list != null || this.list.isEmpty()) {
			ret = "";
		} else {
			Iterator<AbstractPosting> iter = this.list.iterator();
			StringBuffer str = new StringBuffer(iter.next().toString());
			while(iter.hasNext()) {
				str.append(" ");
				str.append(iter.next().toString());
			}
			ret = str.toString();
		}
		return ret;
	}

	@Override
	public void add(List<AbstractPosting> postings) {
		for(AbstractPosting posting : postings) {
			posting.sort();
			this.add(posting);
		}
	}

	@Override
	public AbstractPosting get(int index) {
		return this.list == null ? null : this.list.get(index);
	}

	@Override
	public int indexOf(AbstractPosting posting) {
		return list.indexOf(posting);
	}

	@Override
	public int indexOf(int docId) {
		int index = 0;
		for(AbstractPosting p : this.list) {
			if(p.getDocId() == docId) {
				return index; 
			}
			index++;
		}
		return -1;
	}

	@Override
	public boolean contains(AbstractPosting posting) {
		return this.list.contains(posting);
	}

	@Override
	public void remove(int index) {
		this.list.remove(index);
		
	}

	@Override
	public void remove(AbstractPosting posting) {
		this.list.remove(posting);
		
	}

	@Override
	public int size() {
		return this.list.size();
	}

	@Override
	public void clear() {
		this.list.clear();
		
	}

	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	public void sort() {
		Collections.sort(this.list);
	}
	
}
