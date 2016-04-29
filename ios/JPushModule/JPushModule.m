//
//  JPushModule.m
//  Pet
//
//  Created by Rover on 28/1/16.
//  Copyright © 2016年 Facebook. All rights reserved.
//

#import "JPushModule.h"

@interface JPushModule()

@property (assign) BOOL dealPushFlag;

@end

@implementation JPushModule
@synthesize bridge = _bridge;
@synthesize regID;

RCT_EXPORT_MODULE()


- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

- (instancetype)init
{
    if ((self = [super init])) {
    }
    return self;
}

- (void)initJPush:(NSDictionary *)options{
    if ([[UIDevice currentDevice].systemVersion floatValue] >= 8.0) {
        //可以添加自定义categories
        [JPUSHService registerForRemoteNotificationTypes:(UIUserNotificationTypeBadge|
                                                          UIUserNotificationTypeSound|
                                                          UIUserNotificationTypeAlert
                                                          )
                                              categories:nil];
    } else {
        //categories 必须为nil
        [JPUSHService registerForRemoteNotificationTypes:(UIRemoteNotificationTypeBadge|
                                                          UIRemoteNotificationTypeSound|
                                                          UIRemoteNotificationTypeAlert
                                                          )
                                              categories:nil];
    }
    
    [JPUSHService setupWithOption:options appKey:appKey
                          channel:channel apsForProduction:isProduction];
}

#pragma mark 上报收到的通知内容给JS
- (void)getJPushContent:(NSString *)message
{
    [_bridge.eventDispatcher sendDeviceEventWithName:@"JPushListener" body:@{@"result":message}];
}

#pragma mark 上报极光返回的RegistrationID给JS--(给2秒时间让JS模块启动起来，然后在主线程里面将registrationID发送给JS)
- (void)getJPushRegID:(NSString *)regid{
    self.regID = regid;
    [self performSelector:@selector(waitJSRunFun) withObject:nil afterDelay:2];
}

- (void)waitJSRunFun{
    [self performSelectorOnMainThread:@selector(sendRegistrationOnMianThread) withObject:nil waitUntilDone:YES];
}

- (void)sendRegistrationOnMianThread{
    [_bridge.eventDispatcher sendDeviceEventWithName:@"JPushRegIDListener" body:@{@"result":self.regID}];
}

@end
