package com.biyanzhi.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.biyanzhi.R;
import com.biyanzhi.service.UpdateService;
import com.biyianzhi.interfaces.ConfirmDialog;

import fynn.app.PromptDialog;

public class DialogUtil {
	public static Dialog createLoadingDialog(Context context, String msg) {

		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.loading_dialog, null);// 得到加载view
		LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);// 加载布局
		// main.xml中的ImageView
		ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
		TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
		// 加载动画
		Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
				context, R.anim.load_animation);
		// 使用ImageView显示动画
		spaceshipImage.startAnimation(hyperspaceJumpAnimation);
		tipTextView.setText(msg);// 设置加载信息

		Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog

		// loadingDialog.setCancelable(false);// 不可以用“返回键”取消
		loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
				Utils.getSecreenWidth(context) - 130,
				LinearLayout.LayoutParams.MATCH_PARENT));// 设置布局

		return loadingDialog;

	}

	public static Dialog createLoadingDialog(Context context) {
		return createLoadingDialog(context, "请稍候...");
	}

	/**
	 * 确认对话框
	 * 
	 * @param context
	 * @param title
	 * @param content
	 */
	public static PromptDialog.Builder confirmDialog(Context context,
			String content, String txtOk, String txtCancle,
			final ConfirmDialog callBack) {

		PromptDialog.Builder dialog = new PromptDialog.Builder(context);
		dialog.setTitle("提示");
		dialog.setViewStyle(PromptDialog.VIEW_STYLE_TITLEBAR);
		dialog.setMessage(content);
		dialog.setButton1(txtOk, new PromptDialog.OnClickListener() {

			@Override
			public void onClick(Dialog dialog, int which) {
				dialog.dismiss();
				callBack.onOKClick();

			}
		});
		if (txtCancle != null) {
			dialog.setButton2(txtCancle, new PromptDialog.OnClickListener() {

				@Override
				public void onClick(Dialog dialog, int which) {
					dialog.dismiss();
					callBack.onCancleClick();

				}
			});
		}

		return dialog;

	}

	/**
	 * 新版本提示
	 * 
	 * @param context
	 * @param versionCode
	 * @param link
	 */
	public static void newVewsionDialog(final Context context,
			String versionCode, final String link, String version_info) {
		PromptDialog.Builder dialog = new PromptDialog.Builder(context);
		dialog.setTitle("新版本提示");
		dialog.setViewStyle(PromptDialog.VIEW_STYLE_TITLEBAR);
		dialog.setMessage(versionCode + "\n\n" + version_info);
		dialog.setMessageGravityIsCenter(true);
		dialog.setButton1("立即下载", new PromptDialog.OnClickListener() {

			@Override
			public void onClick(Dialog dialog, int which) {
				dialog.dismiss();
				Intent intent = new Intent();
				intent.setClass(context, UpdateService.class);
				intent.putExtra("url", link);
				context.startService(intent);
			}
		});
		dialog.setButton2("暂不下载", new PromptDialog.OnClickListener() {

			@Override
			public void onClick(Dialog dialog, int which) {
				dialog.dismiss();
			}
		});
		dialog.show();
	}

}
