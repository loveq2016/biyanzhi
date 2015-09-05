package com.biyanzhi.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.biyanzhi.data.result.ApiRequest;
import com.biyanzhi.data.result.Result;
import com.biyanzhi.enums.RetError;
import com.biyanzhi.enums.RetStatus;
import com.biyanzhi.parser.GetPlayScoreUserListPaser;
import com.biyanzhi.parser.IParser;

public class PictureScoreUserList {
	private static final String GET_PLAYSCORE_USERLISTS_BY_PICTUREID = "getPlayScoreUserListsByPictureID.do";

	private int picture_id;
	private List<PictureScore> lists = new ArrayList<PictureScore>();
	private int load_more_count = 0;

	public int getLoad_more_count() {
		return load_more_count;
	}

	public void setLoad_more_count(int load_more_count) {
		this.load_more_count = load_more_count;
	}

	public int getPicture_id() {
		return picture_id;
	}

	public void setPicture_id(int picture_id) {
		this.picture_id = picture_id;
	}

	public List<PictureScore> getLists() {
		return lists;
	}

	public void setLists(List<PictureScore> lists) {
		this.lists = lists;
	}

	public RetError getPlayScoreUserListsByPictureID(int page) {
		IParser parser = new GetPlayScoreUserListPaser();
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("picture_id", picture_id);
		params.put("page", page);
		Result ret = ApiRequest.request(GET_PLAYSCORE_USERLISTS_BY_PICTUREID,
				params, parser);
		if (ret.getStatus() == RetStatus.SUCC) {
			PictureScoreUserList list = (PictureScoreUserList) ret.getData();
			this.lists = list.getLists();
			load_more_count = list.getLists().size();

			return RetError.NONE;
		} else {
			return ret.getErr();
		}
	}
}
