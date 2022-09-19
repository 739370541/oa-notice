package com.kelun.oa.notice.service;

import com.kelun.oa.notice.entity.OaRequest;
import com.kelun.oa.notice.entity.OaResponse;

/**
 * @author yale
 */
public interface OaMessageSendService {

    OaResponse sendMessage(OaRequest oaRequest,String url);
}
