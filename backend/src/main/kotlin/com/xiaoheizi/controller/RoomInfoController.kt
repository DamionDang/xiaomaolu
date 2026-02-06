package com.xiaoheizi.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/room")
@CrossOrigin(origins = ["http://localhost:3000"])
class RoomInfoController {

    @GetMapping("/info")
    fun getRoomInfo(): ResponseEntity<Map<String, Any>> {
        val roomInfo = mapOf(
            "roomId" to "636738",
            "roomName" to "小茅庐",
            "platform" to "小黑盒",
            "category" to "游戏开黑",
            "description" to "这里是专为游戏爱好者打造的温馨空间，提供游戏开黑、经验分享及日常聊天服务",
            "features" to listOf(
                "游戏开黑",
                "经验分享",
                "语音聊天",
                "竞技提升",
                "活动赛事",
                "友好氛围"
            ),
            "onlineStatus" to true,
            "memberCount" to 0, // 实际应用中应该动态获取
            "createTime" to "2024-01-01"
        )

        return ResponseEntity.ok(roomInfo)
    }
}