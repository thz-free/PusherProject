package com.kairlec.pusher.config.properties

import com.kairlec.lib.YAMLPropertySourceFactory
import com.kairlec.pusher.annotation.condition.PusherCondition
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Conditional
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources

@Configuration
@ConfigurationProperties(prefix = "wework.push")
@PropertySources(
        PropertySource("file:user.yml", ignoreResourceNotFound = true, factory = YAMLPropertySourceFactory::class),
        PropertySource("file:user.properties", ignoreResourceNotFound = true)
)
@Conditional(PusherCondition::class)
data class PusherUsersProperties(
        val users: Map<String, Any> = HashMap()
)