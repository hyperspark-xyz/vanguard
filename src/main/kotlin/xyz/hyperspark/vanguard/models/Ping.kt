package xyz.hyperspark.vanguard.models

import java.net.InetAddress
import java.time.Instant

data class Ping(val address: InetAddress, val validBefore: Instant)