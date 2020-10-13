package com.kairlec.pusher.annotation.condition

import org.springframework.boot.autoconfigure.condition.AllNestedConditions
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Conditional
import org.springframework.context.annotation.ConfigurationCondition

class OldPusherBackwardsCompatibilityCondition : AllNestedConditions(ConfigurationCondition.ConfigurationPhase.PARSE_CONFIGURATION) {
    @Conditional(PusherCondition::class)
    internal class PusherEnabled

    @ConditionalOnProperty(prefix = "wework.config", value = ["backwardsCompatibility"], matchIfMissing = false)
    internal class BackwardsCompatibilityEnabled
}