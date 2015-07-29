package com.biyanzhi.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.biyanzhi.R;
import com.biyanzhi.activity.LoginActivity;
import com.biyanzhi.activity.UserInfoActivity;
import com.biyanzhi.data.PK1;
import com.biyanzhi.data.PK2;
import com.biyanzhi.data.PKData;
import com.biyanzhi.data.Share;
import com.biyanzhi.popwindow.MenuPopwindow;
import com.biyanzhi.popwindow.MenuPopwindow.OnMenuListOnclick;
import com.biyanzhi.popwindow.SharePopwindow;
import com.biyanzhi.popwindow.SharePopwindow.SelectMenuOnclick;
import com.biyanzhi.utils.DialogUtil;
import com.biyanzhi.utils.ShareUtil;
import com.biyanzhi.utils.SharedUtils;
import com.biyanzhi.utils.UniversalImageLoadTool;
import com.biyanzhi.utils.Utils;
import com.biyanzhi.view.RoundAngleImageView;

public class PKFinishedApapter extends BaseAdapter {
	private Context mContext;
	private int width;
	private List<PKData> mlists;
	private Dialog dialog;

	public PKFinishedApapter(Context mContext, List<PKData> mlists) {
		this.mContext = mContext;
		width = Utils.getSecreenWidth(mContext) / 2 - 80;// 24 margin值
		this.mlists = mlists;
	}

	@Override
	public int getCount() {
		return mlists.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.pk_finish_item, null);
			holder = new ViewHolder();
			holder.txt_pk1 = (TextView) convertView.findViewById(R.id.txt_pk1);
			holder.txt_pk2 = (TextView) convertView.findViewById(R.id.txt_pk2);
			holder.img_pk1_win = (ImageView) convertView
					.findViewById(R.id.img_pk1_win);
			holder.img_pk2_win = (ImageView) convertView
					.findViewById(R.id.img_pk2_win);
			holder.img_vs = (ImageView) convertView.findViewById(R.id.img_vs);
			holder.img_pk1 = (RoundAngleImageView) convertView
					.findViewById(R.id.img_pk1);
			holder.img_pk2 = (RoundAngleImageView) convertView
					.findViewById(R.id.img_pk2);
			holder.btn_pk1 = (Button) convertView.findViewById(R.id.btn_pk1);
			holder.btn_pk2 = (Button) convertView.findViewById(R.id.btn_pk2);
			holder.btn_pk1
					.setLayoutParams(getButtonLayoutParams(holder.btn_pk1));
			holder.btn_pk2
					.setLayoutParams(getButtonLayoutParams(holder.btn_pk2));
			holder.img_pk1.setLayoutParams(getLayoutParams(holder.img_pk1));
			holder.img_pk2.setLayoutParams(getLayoutParams(holder.img_pk2));
			holder.txt_pk1
					.setLayoutParams(getTextViewLayoutParams(holder.txt_pk1));
			holder.txt_pk2
					.setLayoutParams(getTextViewLayoutParams(holder.txt_pk2));
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		PK1 pk1 = mlists.get(position).getPk1();
		PK2 pk2 = mlists.get(position).getPk2();
		String pk1_picture = pk1.getPk1_user_picture();
		String pk2_picture = pk2.getPk2_user_picture();
		UniversalImageLoadTool.disPlay(pk1_picture, holder.img_pk1,
				R.drawable.picture_default_head);
		UniversalImageLoadTool.disPlay(pk2_picture, holder.img_pk2,
				R.drawable.picture_default_head);
		int pk1_user_id = pk1.getPk1_user_id();
		int pk2_user_id = pk2.getPk2_user_id();
		if ("女".equals(mlists.get(position).getPk1().getPk1_user_gender())) {
			holder.txt_pk1.setTextColor(mContext.getResources().getColor(
					R.color.girl));
			holder.txt_pk2.setTextColor(mContext.getResources().getColor(
					R.color.girl));
			holder.btn_pk1.setBackground(mContext.getResources().getDrawable(
					R.drawable.pk_girl_btn));
			holder.btn_pk2.setBackground(mContext.getResources().getDrawable(
					R.drawable.pk_girl_btn));
			holder.img_vs.setImageResource(R.drawable.girl_vs);
		} else {
			holder.txt_pk1.setTextColor(mContext.getResources().getColor(
					R.color.boy));
			holder.txt_pk2.setTextColor(mContext.getResources().getColor(
					R.color.boy));
			holder.btn_pk1.setBackground(mContext.getResources().getDrawable(
					R.drawable.pk_boy_btn));
			holder.btn_pk2.setBackground(mContext.getResources().getDrawable(
					R.drawable.pk_boy_btn));
			holder.img_vs.setImageResource(R.drawable.boy_vs);
		}

		if (mlists.get(position).getPk_state() == 1) {

			if (mlists.get(position).getPk_winer_user_id() == pk1_user_id) {
				if (pk1_user_id == SharedUtils.getIntUid()) {
					holder.btn_pk1.setText("炫耀一下");
					holder.btn_pk2.setText("失败");
				} else {
					holder.btn_pk1.setText("PK成功");
					if (pk2_user_id == SharedUtils.getIntUid()) {
						holder.btn_pk2.setText("别灰心");
					} else {
						holder.btn_pk2.setText("失败");
					}
				}
				holder.img_pk1_win.setVisibility(View.VISIBLE);
				holder.img_pk2_win.setVisibility(View.GONE);

			} else {
				if (pk2_user_id == SharedUtils.getIntUid()) {
					holder.btn_pk2.setText("炫耀一下");
					holder.btn_pk1.setText("失败");
				} else {
					holder.btn_pk2.setText("PK成功");
					if (pk1_user_id == SharedUtils.getIntUid()) {
						holder.btn_pk1.setText("别灰心");
					} else {
						holder.btn_pk1.setText("失败");
					}
				}
				holder.img_pk2_win.setVisibility(View.VISIBLE);
				holder.img_pk1_win.setVisibility(View.GONE);
			}
		} else {
			holder.img_pk2_win.setVisibility(View.GONE);
			holder.img_pk1_win.setVisibility(View.GONE);
		}
		holder.txt_pk1.setText("总   " + pk1.getPk1_win_count() + "胜/"
				+ pk1.getPk1_fail_count() + "败");
		holder.txt_pk2.setText("总   " + pk2.getPk2_win_count() + "胜/"
				+ pk2.getPk2_fail_count() + "败");
		holder.img_pk1.setOnClickListener(new OnClick(position));
		holder.img_pk2.setOnClickListener(new OnClick(position));
		holder.btn_pk1.setOnClickListener(new OnClick(position));
		holder.btn_pk2.setOnClickListener(new OnClick(position));
		return convertView;
	}

	class ViewHolder {
		RoundAngleImageView img_pk1;
		RoundAngleImageView img_pk2;
		Button btn_pk1;
		Button btn_pk2;
		ImageView img_vs;
		ImageView img_pk1_win;
		ImageView img_pk2_win;
		TextView txt_pk1;
		TextView txt_pk2;

	}

	class OnClick implements OnClickListener {
		private int position;

		public OnClick(int position) {
			this.position = position;
		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.img_pk1:
				if (SharedUtils.getIntUid() == 0) {
					mContext.startActivity(new Intent(mContext,
							LoginActivity.class));
					Utils.leftOutRightIn(mContext);
					return;
				}
				if (SharedUtils.getIntUid() == mlists.get(position).getPk1()
						.getPk1_user_id()) {
					Utils.showBigPicture(mlists.get(position).getPk1()
							.getPk1_user_picture(), mContext);
				} else {
					showMenu(v, mlists.get(position).getPk1().getPk1_user_id(),
							mlists.get(position).getPk1().getPk1_user_picture());
				}

				break;
			case R.id.img_pk2:
				if (SharedUtils.getIntUid() == 0) {
					mContext.startActivity(new Intent(mContext,
							LoginActivity.class));
					Utils.leftOutRightIn(mContext);
					return;
				}
				if (mlists.get(position).getPk_state() == 1) {
					if (SharedUtils.getIntUid() == mlists.get(position)
							.getPk2().getPk2_user_id()) {
						Utils.showBigPicture(mlists.get(position).getPk2()
								.getPk2_user_picture(), mContext);
					} else {
						showMenu(v, mlists.get(position).getPk2()
								.getPk2_user_id(), mlists.get(position)
								.getPk2().getPk2_user_picture());
					}

				}

				break;
			case R.id.btn_pk1:
				if (SharedUtils.getIntUid() == 0) {
					mContext.startActivity(new Intent(mContext,
							LoginActivity.class));
					Utils.leftOutRightIn(mContext);
					return;
				}
				if (mlists.get(position).getPk_state() == 1) {
					if (SharedUtils.getIntUid() == mlists.get(position)
							.getPk1().getPk1_user_id()
							&& mlists.get(position).getPk_winer_user_id() == mlists
									.get(position).getPk1().getPk1_user_id()) {
						xuanYaoShare(v, mlists.get(position).getPk1()
								.getPk1_user_picture());
					}
					return;
				}

				break;
			case R.id.btn_pk2:
				if (SharedUtils.getIntUid() == 0) {
					mContext.startActivity(new Intent(mContext,
							LoginActivity.class));
					Utils.leftOutRightIn(mContext);
					return;
				}
				if (mlists.get(position).getPk_state() == 1) {
					if (SharedUtils.getIntUid() == mlists.get(position)
							.getPk2().getPk2_user_id()
							&& mlists.get(position).getPk_winer_user_id() == mlists
									.get(position).getPk2().getPk2_user_id()) {
						xuanYaoShare(v, mlists.get(position).getPk2()
								.getPk2_user_picture());
					}
					return;
				}

				break;
			default:
				break;
			}
		}
	}

	private void xuanYaoShare(View v, final String img_path) {
		List<Share> lists = new ArrayList<Share>();
		lists.add(new Share("微信朋友圈", R.drawable.share_wx_pyq));
		lists.add(new Share("微信好友", R.drawable.share_wx_py));
		lists.add(new Share("QQ好友", R.drawable.share_qq));
		lists.add(new Share("QQ空间", R.drawable.share_qzone));
		lists.add(new Share("新浪微博", R.drawable.share_sina));
		SharePopwindow share_pop = new SharePopwindow(mContext, v, lists);
		share_pop.setmSelectOnclick(new SelectMenuOnclick() {

			@Override
			public void onClickPosition(int position) {
				switch (position) {
				case 0:
					ShareUtil
							.shareWechatMoments(
									"我在  比颜值  APP的PK大赛中成功PK掉了对手,获取了胜利。你们也快来PK吧",
									"我在  比颜值  APP的PK大赛中成功PK掉了对手,获取了胜利。你们也快来PK吧http://123.56.46.254/biyanzhi/biyanzhi.html",
									img_path);
					break;
				case 1:
					ShareUtil
							.shareWechat(
									"我在  比颜值  APP的PK大赛中成功PK掉了对手,获取了胜利。你们也快来PK吧http://123.56.46.254/biyanzhi/biyanzhi.html",
									img_path);
					break;
				case 2:
					ShareUtil
							.shareQQ(
									"我在  比颜值  APP的PK大赛中成功PK掉了对手,获取了胜利。你们也快来PK吧http://123.56.46.254/biyanzhi/biyanzhi.html",
									img_path);
					break;
				case 3:
					ShareUtil
							.shareQQZone(
									"我在  比颜值  APP的PK大赛中成功PK掉了对手,获取了胜利。你们也快来PK吧http://123.56.46.254/biyanzhi/biyanzhi.html",
									img_path);
					break;
				case 4:
					ShareUtil
							.shareSinaWeiBo(
									"我在  比颜值  APP的PK大赛中成功PK掉了对手,获取了胜利。你们也快来PK吧",
									"我在  比颜值  APP的PK大赛中成功PK掉了对手,获取了胜利。你们也快来PK吧http://123.56.46.254/biyanzhi/biyanzhi.html",
									img_path);
					break;
				default:
					break;
				}
			}
		});
		share_pop.show();
	}

	private void showMenu(View v, final int user_id, final String picture_url) {
		MenuPopwindow pop = new MenuPopwindow(mContext, v, new String[] {
				"看大图", "PK  TA", "查看PK者信息" });
		pop.setCallback(new OnMenuListOnclick() {

			@Override
			public void onclick(int position) {
				switch (position) {
				case 0:
					Utils.showBigPicture(picture_url, mContext);
					break;
				case 1:
					// mContext.startActivity(new Intent(mContext,
					// UserInfoActivity.class)
					// .putExtra("user_id", user_id));
					// Utils.leftOutRightIn(mContext);
					break;
				case 2:
					mContext.startActivity(new Intent(mContext,
							UserInfoActivity.class)
							.putExtra("user_id", user_id));
					Utils.leftOutRightIn(mContext);
					break;
				default:
					break;
				}
			}
		});
		pop.show();
	}

	private LayoutParams getLayoutParams(RoundAngleImageView img) {
		LayoutParams layoutParams = img.getLayoutParams();
		layoutParams.width = width;
		layoutParams.height = width;
		return layoutParams;
	}

	private LayoutParams getButtonLayoutParams(Button btn) {
		LayoutParams layoutParams = btn.getLayoutParams();
		layoutParams.width = width;
		return layoutParams;
	}

	private LayoutParams getTextViewLayoutParams(TextView btn) {
		LayoutParams layoutParams = btn.getLayoutParams();
		layoutParams.width = width;
		return layoutParams;
	}

	private void showDialow() {
		dialog = DialogUtil.createLoadingDialog(mContext, "投票中...");
		dialog.show();
	}

	private void dismissDialog() {
		if (dialog != null) {
			dialog.dismiss();
		}
	}
}
