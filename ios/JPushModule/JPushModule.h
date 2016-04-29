//
//  JPushModule.h
//  Pet
//
//  Created by Rover on 28/1/16.
//  Copyright © 2016年 Facebook. All rights reserved.
//

#import "RCTViewManager.h"
#import "JPUSHService.h"
#import "RCTBridgeModule.h"

static NSString *appKey = @"b75ab1c1aa291e0e729370c3";
static NSString *channel = @"Publish channel";
static BOOL isProduction = FALSE;

@interface JPushModule : NSObject<RCTBridgeModule>{
    NSString *regID;
}
@property (nonatomic, retain) NSString *regID;


- (void)initJPush:(NSDictionary *)options;

- (void)getJPushContent:(NSString *)message;

- (void)getJPushRegID:(NSString *)regid;


@end
