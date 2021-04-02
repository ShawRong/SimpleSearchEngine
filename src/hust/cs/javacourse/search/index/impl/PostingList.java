package hust.cs.javacourse.search.index.impl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import hust.cs.javacourse.search.index.AbstractPosting;
import hust.cs.javacourse.search.index.AbstractPostingList;

public class PostingList extends AbstractPostingList{

	@Override
	public void writeObject(ObjectOutputStream out) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readObject(ObjectInputStream in) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
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
		return 
	}

	@Override
	public int indexOf(AbstractPosting posting) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int indexOf(int docId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(AbstractPosting posting) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(AbstractPosting posting) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}
	
}
