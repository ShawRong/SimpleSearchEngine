package hust.cs.javacourse.search.index.impl;

import hust.cs.javacourse.search.index.AbstractTermTuple;
import hust.cs.javacourse.search.index.AbstractTerm;

public class TermTuple extends AbstractTermTuple{
	
	public TermTuple() {
		
	}
	
	public TermTuple(AbstractTerm term, int curPos) {
		this.term = term;
		this.curPos = curPos;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean flag = false;
		if(obj instanceof AbstractTermTuple) {
			if(this.curPos == ((AbstractTermTuple) obj).curPos && this.term.equals(((AbstractTermTuple)obj).term)){
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public String toString() {
		return "Term:" + term.toString() + "CurPos:" + curPos + ";";
	}
}
