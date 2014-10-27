package com.sina.sae.cloudservice.api;

import java.util.HashMap;
import java.util.Map;

import android.util.Log;

import com.google.gson.JsonObject;
import com.sina.sae.cloudservice.callback.ExecuteCallback;
import com.sina.sae.cloudservice.exception.CloudServiceException;

public class CloudComment {

	public static int sendComment(String userid, String username, String sgfurl, String comment)
			throws CloudServiceException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userid", userid);
		params.put("username", username);
		params.put("sgfurl", sgfurl);
		params.put("comment", comment);
		CommonParams.addCommonParams(params);

		JsonObject json = CloudClient.post(CloudClient.REST_COMMENT, params, null);
		if (json != null) {
			int code = json.get("code").getAsInt();
			String message = json.get("message").getAsString();
			if (0 == code && "success".equalsIgnoreCase(message)) {
				return code;
			} else {
				String errorMessage = "CloudComment.sendComment(" + userid + "," + username + ","
						+ sgfurl + "," + comment + ") Error!Code: " + code + " message:" + message;
				Log.e("CloudService", errorMessage);
				throw new CloudServiceException(errorMessage, code);
			}
		} else {
			return -1;
		}
	}

	public static void register(String userid, String username, String sgfurl, String comment,
			ExecuteCallback callback) throws CloudServiceException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userid", userid);
		params.put("username", username);
		params.put("sgfurl", sgfurl);
		params.put("comment", comment);
		CommonParams.addCommonParams(params);

		CloudClient.post(CloudClient.REST_COMMENT, params, callback);
	}
}
