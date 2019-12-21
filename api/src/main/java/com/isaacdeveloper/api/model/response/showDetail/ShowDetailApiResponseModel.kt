package com.isaacdeveloper.api.model.response.showDetail

import com.isaacdeveloper.api.model.ResponseState
import com.isaacdeveloper.api.model.response.commonShowsModels.Data

class ShowDetailApiResponseModel(
    val data: Data?,
    var responseState: ResponseState
)