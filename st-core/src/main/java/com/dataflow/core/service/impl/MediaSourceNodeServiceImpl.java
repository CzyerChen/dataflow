package com.dataflow.core.service.impl;


import com.dataflow.common.domain.MediaSourceNodePO;
import com.dataflow.core.repository.MediaSourceNodeRepository;
import com.dataflow.core.service.MediaSourceNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
Qi Hua  媒体节点服务类
 */
@Service
public class MediaSourceNodeServiceImpl implements MediaSourceNodeService {
	@Autowired
	private MediaSourceNodeRepository mediaSourceNodeRepository;

	@Override
	public MediaSourceNodePO saveMediaSourceNode(MediaSourceNodePO msnp) {
		return mediaSourceNodeRepository.save(msnp);
	}

	@Override
	public void deleteMediaSourceNodeById(String id) {
		MediaSourceNodePO mediaSourceNodePO = mediaSourceNodeRepository.findByIdAndDeleted(id,false);
		if(mediaSourceNodePO!=null){
			mediaSourceNodePO.setDeleted(true);
			mediaSourceNodeRepository.save(mediaSourceNodePO);
		}
	}

	@Override
	public MediaSourceNodePO selectMediaSourceNodeById(String id) {
		return mediaSourceNodeRepository.findByIdAndDeleted(id,false);
	}
}
